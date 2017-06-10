'use strict';

let Lazy = require('lazy.js');

function* idMaker() {
  let id = 50;
  while(true)
    yield id++;
}
let genId = idMaker();

function dataset() {
  let id = Math.ceil(Math.random() * 50);
  // let id = genId.next().value;
  return {
    id: id,
    customer: {
      name: "customer" + id
    },
    total: id
  };
}
const MAX = 1000000;

console.time('arr');
var arr = [...Array(MAX)].map((_, i) => ++i).map(x => dataset())
console.timeEnd('arr');


function chainOperations() {
  return Lazy(arr)
    .filter(x => x.id > 20)
    .filter(x => !(x.id % 2))
    .pluck('customer')
    .filter(x => x.name)
    .take(50)
    .some(x => x.name === 'customer30');
}

console.log('Filters batch 1')
console.time('NodeJS lazy.js ');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js ');

console.time('NodeJS lazy.js 2');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js 2');

console.time('NodeJS lazy.js 3');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js 3');
console.log('\n\n')


console.log('Filters batch 2')
console.time('NodeJS lazy.js ');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js ');

console.time('NodeJS lazy.js 2');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js 2');

console.time('NodeJS lazy.js 3');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js 3');
console.log('\n\n')


console.log('Filters batch 3')
console.time('NodeJS lazy.js ');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js ');

console.time('NodeJS lazy.js 2');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js 2');

console.time('NodeJS lazy.js 3');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js 3');
console.log('\n\n')



console.log('Filters batch 4')
console.time('NodeJS lazy.js ');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js ');

console.time('NodeJS lazy.js 2');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js 2');

console.time('NodeJS lazy.js 3');
console.log('is present: ' + chainOperations());
console.timeEnd('NodeJS lazy.js 3');
console.log('\n\n')
