const mongoose = require('mongoose');
const {Schema} = mongoose;

const UserModel = new Schema({
	name : {
		type:String,
		required:true,
		trim:true
	},
	email: {
		type:String,
		required:true,
		trim:true
	},
	password: {
		type:String,
		required:true,
	},
	profileImage: {
		type:String,
		required:false
	},
	lastSeen: {
		type:Date
	}
});

const User = new mongoose.model('users',UserModel);

module.exports = User;