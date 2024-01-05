const express=require('express')
const app = express()

const { faker } = require('@faker-js/faker');

const createUser=()=>{
    const user = {
        password: faker.internet.password(),
        email: faker.internet.email(),
        number : faker.number.int(29999999),
        username: faker.internet.userName(),
        _id : faker.string.uuid()
        };
    return user;
} 

const createCompany = () => {
    const company = {
        _id : faker.string.uuid(),
        name: faker.commerce.productName(),
        address : {
        street : faker.location.street(),
        city : faker.location.city(),
        state : faker.location.state(),
        zipCode : faker.location.zipCode(),
        country : faker.location.country()
        }

        };
    return company;
};

app.use( express.json() );
app.use( express.urlencoded({ extended: true }) );


// ! test route
app.get('/' , (req , res) => {
    res.json({message : "server is up and running " , ok : true})
})
/*
CREATE a User
Method : POST
host : localhost
url : http://localhost/8000/api/users/new
res : [object]
*/
app.post('/api/users/new', (req, res) => {
    // console.log(req.body);
    req.body = createUser()
    res.status(201).json({ newUser: req.body, message: "User created successfully", ok: true })
})
/*
CREATE a User
Method : POST
host : localhost
url : http://localhost/8000/api/companies/new
res : [object]
*/
app.post(`/api/companies/new` , (req , res) => {
    req.body = createCompany()
    res.status(201).json({ newCompany : req.body , message :" company created successfully" , ok : true})
})

app.post(`/api/user/company` , (req , res) => {
    res.status(201).json({  newUser : createUser() ,newCompany : createCompany() , message :" user and company are created successfully" , ok : true})
})

app.listen(8000 , () => {
    console.log("http://localhost:8000/")
    console.log('server is  running  on port 8000 💥💥💥💥');
})