var http = require('http');

var finalhandler = require('finalhandler');
var serveStatic = require('serve-static');

var serve = serveStatic("./");

var server = http.createServer(function(req, res) {

console.log("Serving...");
  var done = finalhandler(req, res);
  serve(req, res, done);
});

console.log("Listening...");
server.listen(8000);
