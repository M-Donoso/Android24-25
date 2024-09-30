// Crear el mapa y establecer la vista inicial
var map = L.map('map').setView([0, 0], 2);

// Definir diferentes capas de mapas base
var capasBase = {
    "OpenStreetMap": L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
        maxZoom: 15,
        minZoom: 1.5
    }),
    "CartoDB Positron": L.tileLayer('https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}{r}.png', {
        attribution: '&copy; <a href="https://carto.com/">CARTO</a>',
        subdomains: 'abcd',
        maxZoom: 15,
        minZoom: 1.5
    }),
    "Esri World Imagery": L.tileLayer('https://services.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', {
        attribution: 'Tiles © Esri &mdash; Source: Esri, i-cubed, USDA, USGS, AEX, GeoEye, Getmapping, Aerogrid, IGN, IGP, UPR-EGP, and the GIS User Community',
        maxZoom: 15,
        minZoom: 1.5
    })
};

// Agregar la capa de OpenStreetMap como la predeterminada
capasBase["OpenStreetMap"].addTo(map);

// Añadir un control de capas para cambiar entre los diferentes mapas base
L.control.layers(capasBase).addTo(map);

// Función para obtener eventos desde la API de EONET sin filtrar por fechas
async function obtenerEventosEONET() {
    const url = 'https://eonet.gsfc.nasa.gov/api/v3/events';
    const response = await fetch(url);
    const data = await response.json();
    return data.events;
}

// Función para seleccionar el emoji adecuado según el tipo de evento
function obtenerEmojiPorTipo(tipoEvento) {
    const tipos = {
        "Wildfires": "🔥",
        "Severe Storms": "🌪️",
        "Volcanoes": "🌋",
        "Floods": "🌊",
        "Icebergs": "🧊",
        "Sea and Lake Ice": "🧊",
        "Earthquakes": "🌍",
        "Landslides": "🏞️"
    };
    return tipos[tipoEvento] || "❓"; // Emoji por defecto si no se encuentra
}

// Función para limpiar los marcadores anteriores en el mapa
function limpiarMapa() {
    map.eachLayer(function (layer) {
        if (!!layer.toGeoJSON) {
            map.removeLayer(layer);
        }
    });

    // Mantener la capa base seleccionada (la que el usuario eligió)
    let activeBaseLayer;
    for (let layerName in capasBase) {
        if (map.hasLayer(capasBase[layerName])) {
            activeBaseLayer = capasBase[layerName];
        }
    }

    if (activeBaseLayer) {
        activeBaseLayer.addTo(map);
    }
}

// Función para mostrar todos los eventos en el mapa
async function mostrarEventosEnMapa(startDate, endDate) {
    limpiarMapa();  
    const eventos = await obtenerEventosEONET(startDate, endDate);
    
    const coordenadasVistas = new Set(); 

    // Crear un grupo de marcadores
    var markers = L.markerClusterGroup();

    eventos.forEach(evento => {
        if (evento.geometry) {
            evento.geometry.forEach(geo => {
                const lat = geo.coordinates[1]; 
                const lon = geo.coordinates[0]; 
                const coordenadaClave = `${lat},${lon}`; 

                // Solo agregar el marcador si la coordenada no ha sido vista antes
                if (!coordenadasVistas.has(coordenadaClave)) {
                    coordenadasVistas.add(coordenadaClave); 
                    var emojiIcon = L.divIcon({
                        className: 'emoji-icon',
                        html: obtenerEmojiPorTipo(evento.categories[0].title) 
                    });

                    // Crear el contenido del popup con más detalles del evento
                    var popupContent = `<b>${evento.title}</b><br>
                                        ${obtenerEmojiPorTipo(evento.categories[0].title)}<br>
                                        <b>Fecha:</b> ${new Date(evento.geometry[0].date).toLocaleDateString()}<br>
                                        <b>Descripción:</b> ${evento.description || 'No disponible'}<br>
                                        <b>Fuente:</b> <a href="${evento.sources[0].url}" target="_blank">${evento.sources[0].id}</a>`;

                    // Crear el marcador y agregarlo al grupo
                    var marker = L.marker([lat, lon], { icon: emojiIcon })
                        .bindPopup(popupContent);
                    
                    markers.addLayer(marker);
                }
            });
        }
    });
    map.addLayer(markers);
}


// Añadir un evento de escucha al formulario de filtrado por fechas
document.getElementById('dateForm').addEventListener('submit', async function(e) {
    e.preventDefault(); 

    // Obtener los valores de las fechas de inicio y fin del formulario
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;

    // Mostrar los eventos filtrados por fecha
    mostrarEventosEnMapa(startDate, endDate);
});

    // Modificar la función para obtener eventos desde la API de EONET con un filtro de fechas
    async function obtenerEventosEONET(startDate, endDate) {
    const baseUrl = 'https://eonet.gsfc.nasa.gov/api/v3/events';

    // Si hay fechas de inicio y fin, agregarlas a la URL como parámetros
    const url = startDate && endDate ? `${baseUrl}?start=${startDate}&end=${endDate}` : baseUrl;

    const response = await fetch(url);
    const data = await response.json();
    return data.events;
}

// Modificar la función para mostrar eventos en el mapa según el rango de fechas
async function mostrarEventosEnMapa(startDate, endDate) {
    limpiarMapa();  
    const eventos = await obtenerEventosEONET(startDate, endDate);
    
    const coordenadasVistas = new Set(); 

    // Crear un grupo de marcadores
    var markers = L.markerClusterGroup();

    eventos.forEach(evento => {
        if (evento.geometry) {
            evento.geometry.forEach(geo => {
                const lat = geo.coordinates[1]; 
                const lon = geo.coordinates[0]; 
                const coordenadaClave = `${lat},${lon}`; 

                // Solo agregar el marcador si la coordenada no ha sido vista antes
                if (!coordenadasVistas.has(coordenadaClave)) {
                    coordenadasVistas.add(coordenadaClave); 
                    var emojiIcon = L.divIcon({
                        className: 'emoji-icon',
                        html: obtenerEmojiPorTipo(evento.categories[0].title) 
                    });

                    // Crear el marcador y agregarlo al grupo
                    var marker = L.marker([lat, lon], { icon: emojiIcon })
                        .bindPopup(`<b>${evento.title}</b><br>${obtenerEmojiPorTipo(evento.categories[0].title)}`);
                    
                    markers.addLayer(marker);
                }
            });
        }
    });

    map.addLayer(markers);
}

// Mostrar eventos por defecto al cargar la página (sin filtrar)
mostrarEventosEnMapa();

// Mostrar eventos por defecto al cargar la página
mostrarEventosEnMapa();


