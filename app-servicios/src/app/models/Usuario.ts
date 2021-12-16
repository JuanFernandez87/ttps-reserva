export class Usuario {
    nombre: string;
    apellido: string;
    dni: number;
    user: string;
    mail: string;
    pass: string;
    fechaNac!: Date;

    constructor(nombre: string,apellido: string,dni: number, user: string, password: string,email: string,fechaNac: Date) {
        this.mail = email;
        this.pass = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.dni = dni;
        this.fechaNac = fechaNac;
    }
}