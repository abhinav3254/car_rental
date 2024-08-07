const jwt = require('jsonwebtoken');

const {jwt_secret} = require('../config/config');

function verfiyToken(req,res,next) {

	console.log('hehe');

	const token = req.cookies.token;
	if (!token) {
		return res.status(401).json({message:'Access denied'});
	}

	try {
		const decoded = jwt.verify(token,jwt_secret);
		req.userId = decoded.userId;
		next();

	} catch(err) {
		return res.status(401).json({message:err});
	}
}

module.exports = verfiyToken;
