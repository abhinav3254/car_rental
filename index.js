const express = require('express');

const app = express();

const { port,jwt_secret } = require('./config/config');

const User = require('./models/User');

const cors = require('cors');

// configuring node to use json
app.use(express.json());
app.use(cors({
	origin: 'http://localhost:3000',
    credentials: true,
}));

// cookie
const cookieParser = require('cookie-parser');
app.use(cookieParser());

// jwt
const jwt = require('jsonwebtoken');

// db connection
require('./config/db-config');

// authMiddleware
const verfiyToken = require('./middlwares/authMiddleware');


// websocket
const {WebSocketServer} = require('ws');


app.get('',(req,res)=>{
	return res.json({message:'Hola! server\'s up'});
});


app.post('/register',async (req,res) => {
	try {

		const {name,email,password} = req.body;

		const existingUser = await User.findOne({email});

		if (existingUser) {
			return res.status(400).json({message:'Email already in use.'});
		}

		const newUser = new User({
			name,email,password
		});

		await newUser.save();

		return res.json({message:'User registered!'});

	} catch(err) {
		return res.json(err);
	}
});


app.post('/login',async (req,res)=>{
	try {

		const {email,password} = req.body;

		const existingUser = await User.findOne({email});

		if (existingUser) {

			if (existingUser.password === password) {

				const token = jwt.sign({userId:existingUser._id},jwt_secret,{expiresIn:'892h'});

				res.cookie('token',token);

				return res.status(200).json({message:`Welcome back ${existingUser.name}`});

			} return res.status(400).json({message:'Wrong password'});

		} return res.status(404).json({message:'User not found'});

	} catch(err) {
		return res.json(err);
	}
});


app.get('/profile',verfiyToken, async (req,res) => {
	try {

		const userId = req.userId;
		if (!userId) {
			return res.status(401).json({message:'Token Not found'});
		}
		const user = await User.findById(userId);

		if (!user) {
            return res.status(404).json({ message: 'User not found' });
        }

        const refinedUser = {
        	_id:user._id,
        	name:user.name,
        	email:user.email,
        	profileImage:user.profileImage,
        	lastSeen:user.lastSeen
        }

		return res.status(200).json(refinedUser);

	} catch(err) {
		return res.json(err);
	}
});


const server = app.listen(port,() => {
	console.log(`server is up and running on port ${port}`);
});



// websocket code starts from here....

const ws = new WebSocketServer({server});

ws.on('connection',(connection,req) => {
	const token = req.headers.cookie.substring(6);
	if (token) {
		try {
			const decode = jwt.verify(token,jwt_secret);
			req.userId = decode.userId;
			console.log(`${req.userId} connected 🎉`);
		} catch(err) {
			console.log('decode failed in web socket',err);
		}
	}

	connection.on('close',()=>{
		console.log(`${req.userId} diconnected 🫦`);
	})
});
