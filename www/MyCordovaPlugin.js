
const exec = require('cordova/exec');

const PLUGIN_NAME = 'MyCordovaPlugin';

let MyCordovaPlugin = {
  echo: function(args, successCallBack , failureCallback) {
    exec(successCallBack, failureCallback, PLUGIN_NAME, 'echo', [args]);
  }
};

module.exports = MyCordovaPlugin;
