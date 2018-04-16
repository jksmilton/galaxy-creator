var container = document.getElementById('galaxyContainer');
container.innerHTML = "Loading...";

var scene = new THREE.Scene();
var camera = new THREE.PerspectiveCamera( 75, 4/3, 0.1, 1000);
var renderer = new THREE.WebGLRenderer();

var stars = [];

function handleGalaxyResonse() {

    if (this.readyState == 4 && this.status == 200) {
        

        renderer.setSize(800, 600);

        var starGeometry = new THREE.SphereGeometry(0.25);        
        var commonMaterial = new THREE.MeshBasicMaterial( {color: 0xfaea0a} );


        var responseJson = JSON.parse(this.responseText);

        responseJson.forEach(function(element, index) {
            stars.push(new THREE.Mesh(starGeometry, commonMaterial));
            stars[index].position.x = element.x;
            stars[index].position.y = element.y;
            stars[index].position.z = element.z;

            scene.add(stars[index]);

        });
        camera.position.z = 100;

        container.innerHTML = "";
        container.appendChild( renderer.domElement );

        render();

    }
}

function render() {
    requestAnimationFrame( render );
    renderer.render( scene, camera );
}

var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = handleGalaxyResonse;

xhttp.open("GET", "/api/createGalaxy", true);
xhttp.send();