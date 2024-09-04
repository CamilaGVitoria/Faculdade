const express = require('express');
const router = express.Router();

const loginController = require('../controler/loginController');
const loginValidator = require('../validator/loginValidator');
const auth = require('../middleware/auth');

router.post('/auth/register', loginValidator.manipulateLogin, loginController.register);
router.post('/auth/login', loginValidator.manipulateLogin, loginController.login)
router.get('/user/:id', auth, loginController.getUser);
router.delete('/user/:id', auth, loginController.deleteUser);
router.put('/user/:id', auth, loginValidator.manipulateLogin, loginController.editUser);

module.exports = router;
