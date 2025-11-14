let token = '';

async function login() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    
    const response = await fetch('http://127.0.0.1:8000/api/login', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({email, password})
    });
    
    const data = await response.json();
    
    if (data.token) {
        token = data.token;
        document.getElementById('login').style.display = 'none';
        document.getElementById('personas').style.display = 'block';
        alert('Login exitoso!');
        cargarPersonasGraphQL();
    }
}

async function graphqlRequest(query, variables = {}) {
    const response = await fetch('http://127.0.0.1:8000/graphql', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': token ? 'Bearer ' + token : ''
        },
        body: JSON.stringify({
            query: query,
            variables: variables
        })
    });
    
    return await response.json();
}

async function crearPersonaGraphQL() {
    const nombres = document.getElementById('nombres').value;
    const apellidos = document.getElementById('apellidos').value;
    const ci = document.getElementById('ci').value;
    const email = document.getElementById('personaEmail').value;
    
    const mutation = `
        mutation CreatePersona($nombres: String!, $apellidos: String!, $ci: String!, $email: String) {
            createPersona(nombres: $nombres, apellidos: $apellidos, ci: $ci, email: $email) {
                id
                nombres
                apellidos
                ci
                email
            }
        }
    `;
    
    const result = await graphqlRequest(mutation, {nombres, apellidos, ci, email});
    
    if (result.data) {
        alert('Persona creada con GraphQL!');
        document.getElementById('nombres').value = '';
        document.getElementById('apellidos').value = '';
        document.getElementById('ci').value = '';
        document.getElementById('personaEmail').value = '';
        cargarPersonasGraphQL();
    }
}

async function cargarPersonasGraphQL() {
    const query = `
        query GetPersonas {
            personas {
                id
                nombres
                apellidos
                ci
                email
                direccion
                telefono
            }
        }
    `;
    
    const result = await graphqlRequest(query);
    
    if (result.data) {
        let html = '<h4>Datos desde GraphQL:</h4>';
        result.data.personas.forEach(p => {
            html += `<p>${p.nombres} ${p.apellidos} - ${p.ci} - ${p.email}</p>`;
        });
        document.getElementById('lista').innerHTML = html;
    }
}