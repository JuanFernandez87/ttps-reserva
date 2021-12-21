export class Servicio {
    id!: number;
    nombre: string;
    tipo_servicio: string;
    descripcion: string;
    url: string;
    id_usuario!: string | null;
    constructor(nombre: string, tipo_servicio: string, descripcion: string, url: string) {
        this.nombre = nombre;
        this.tipo_servicio = tipo_servicio;
        this.descripcion = descripcion;
        this.url = url;
    }
    
}