const express = require('express');
const router = express.Router();

const loginController = require('../controler/loginController');
const loginValidator = require('../validator/loginValidator');
const { checkToken } = require('../middleware/authMiddleware');

router.post('/auth/register', loginValidator.manipulateLogin, loginController.register);
router.post('/auth/login', loginValidator.manipulateLogin, loginController.login)
router.get('/user/:id', checkToken, loginController.getUser);
router.delete('/user/:id', loginController.deleteUser);

module.exports = router;
