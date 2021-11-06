var express = require('express');
var bcrypt = require('bcrypt');
var models = require('./models');
var router = express.Router();

router.post('/member', function(req, res, next) {
  req.body.password = bcrypt.hashSync(req.body.password, 10);
  req.body.point = 0;
  console.log(req.body);
  models.Member.create(req.body, {
    fields: ['university_id', 'name', 'nickname', 'password', 'telephone', 'point']
  })
  .then(() => res.status(201).end())
  .catch(err => {
    res.body = err.message;
    res.status(400).end();
  });
});

router.get('/member/:id', function(req, res, next) {
  models.Member.findByPk(req.params.id, {
    attributes: ['university_id', 'name', 'nickname', 'telephone', 'point']
  })
  .then(member => {
    if (member) res.json(member);
    else res.status(404).end();
  })
  .catch(err => {
    res.body = err.message;
    res.status(400).end();
  });
});

router.put('/member/:id', function(req, res, next) {
  req.body.password = bcrypt.hashSync(req.body.password, 10);
  models.Member.update(req.body, {
    fields: ['password', 'telephone'],
    where: { id: req.params.id }
  })
  .then(member => {
    if (member) res.status(200).end();
    else res.status(404).end();
  })
  .catch(err => {
    res.body = err.message;
    res.status(400).end();
  });
});

router.get('/login', function(req, res, next) {
  models.Member.findOne({
    where: {
      nickname: req.body.nickname
    }
  })
  .then(member => {
    if (member && bcrypt.compareSync(req.body.password, member.password)) {
      res.json({'id': member.id});
    }
    else res.status(404).end();
  })
  .catch(err => {
    res.body = err.message;
    res.status(400).end();
  });
});

router.post('/mail/send', function(req, res, next) {
  
});

router.post('/mail/check', function(req, res, next) {
  
});

router.post('/restaurant', function(req, res, next) {
  
});

router.post('/menu', function(req, res, next) {
  
});

module.exports = router;