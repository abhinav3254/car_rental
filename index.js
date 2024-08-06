const express = require('express');

const app = express();

const { port } = require('./config/config');

app.get('',(req,res)=>{
	return res.json({message:'Hola! server\'s up'});
});

const server = app.listen(port,()=>{
	console.log(`server is up and running on port ${port}`);
});