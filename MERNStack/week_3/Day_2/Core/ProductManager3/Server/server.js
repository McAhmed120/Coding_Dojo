const express  = require('express');
const cors = require('cors');
const app  = express();
require('dotenv').config();
// --------------------------------MIDDLEWARE
app.use( express.json() );
app.use( express.urlencoded({ extended: true }) );
app.use(cors())
// ------------------------- CONNECT WITH DATABASE
require('./config/mongoose.config')
//-------------------------------- ALL ROUTES
require('./routes/product.route')(app)

// -------------------------------RUN SERVER
app.listen(process.env.port,()=>{
    console.log('SERVER IS RUNNING ON PORT ',process.env.port);
    console.log(`http://localhost:${process.env.port}`);
})