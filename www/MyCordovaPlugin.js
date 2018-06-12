
var exec = require('cordova/exec');

var PLUGIN_NAME = 'MyCordovaPlugin';

var MyCordovaPlugin = {
  echo: function(args, successCallBack , failureCallback) {
    exec(successCallBack, failureCallback, PLUGIN_NAME, 'echo', [args]);
  }
};

module.exports = MyCordovaPlugin;
