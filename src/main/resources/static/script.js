/*const myHeaders = new Headers()
myHeaders.set('Content-Type', 'application/json');

const myInit = {
  method: 'GET',
  headers: myHeaders,
  mode: 'cors',
  cache: 'default',
};*/


/*
document.getElementById('create-track').addEventListener('click', () => {
  const name = document.getElementById('article-name').value;

  const myInitPost = {
    method: 'POST',
    headers: myHeaders,
    body: JSON.stringify({
      name,
      price: 1800.10
    })
  };
  createArticle(myInitPost);
});

createArticle = (param) => {
  fetch('http://localhost:8080/products', param)
    .then(function (response) {
      response.json().then((product) => {
        convertProductToHTML(product);
      });
    });
};
*/

/*fetch('http://localhost:8080/tracks', myInit)
  .then(function (response) {
    response.json().then((tracks) => {
      console.log({tracks});
      handleProducts(tracks);
    });
  });


handleProducts = (tracks) => {
  for (const track of tracks) {
    convertProductToHTML(track);
  }
}

convertProductToHTML = (track) => {
  const text = `Track : ${track.name}`;
  const divElement = document.createElement('div');
  divElement.append(text);
  document.getElementById('list').appendChild(divElement);
}*/
