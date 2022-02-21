# Actividad JPA + Hibernate con el metodo CRUD

_Maycol Steven Rincon_

## Informacion del programa

Tiene tres entidades:

- Employee
- Role
- Project

Los Employee tiene una conexion de Many to One con Role, y Many to Many con Pojects.

**Para ingresar información al employe se debe ingresar en un Json de la siguiente manera:**

    {
        "id": 1,
        "firstName": "Ciri",
        "lastName": "Jones",
        "employeeid": "empl001",
        "role": {
            "id": 1,
            "name": "Admin"
        },
        "projects": [{
            "id" : 1,
            "name" : "Desarrollo3D"
        }]
    }

El campo id es autogenerado, se coloca de ejemplificacion.

El programa cuenta con los metodos CRUD:

- Obtener todos
- Obtener por id
- Crear
- Actualizar
- Eliminar por id

El metodo update utiliza el request http : PUT, mientras que el método add utliza el request http : POST.
