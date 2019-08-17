const pad = require('pad-left');

function scared(scareLevel) {
    return pad('H!!!', scareLevel, 'A');
}

module.exports = scared;

