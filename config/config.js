const dotenv = require('dotenv');

dotenv.config();

module.exports = {
	port : process.env.PORT,
	jwt_secret:process.env.JWT_SECRET_KEY,
	db_url:process.env.DB_URL
}