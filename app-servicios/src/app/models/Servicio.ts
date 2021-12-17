export class Servicio {
    nombre: string;
    tipo_servicio: string;
    descripcion: string;
    url: string;
    id_usuario!: string | null;
    constructor(nombre: string, tipo: string, descripcion: string, url: string) {
        this.nombre = nombre;
        this.tipo_servicio = tipo;
        this.descripcion = descripcion;
        this.url = url;

    }
    
}