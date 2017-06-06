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
  return arr
    .filter(x => x.id > 20)
    .filter(x => !(x.id % 2))
    .map(x => x.customer)
    .filter(x => x.name)
    .slice(0,50)
    .some(x => x.name === 'customer30');
}

console.time('chain');
console.log(chainOperations());
console.timeEnd('chain');

console.time('chain2');
console.log(chainOperations());
console.timeEnd('chain2');

console.time('chain3');
console.log(chainOperations());
console.timeEnd('chain3');
