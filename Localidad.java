public class Localidad{
    private String nombre;
    private int capacidad;
    private float precio;
    private int pos;

    public Localidad(){
        this.nombre = "";
        this.capacidad = 0;
        this.precio = 0;
        this.pos = 0;
    }

    public Localidad(int capacidad, int pos){
        this.capacidad = capacidad;
        this.pos = pos;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String toString(){
        if (pos == 1){
            this.nombre = "Balcón VIP";
            this.precio = 1800;
            return "Localidad: "+nombre+"\nCapacidad: "+capacidad+"\nPrecio por boleto: "+precio;
        }

        if (pos == 2){
            this.nombre = "Platea";
            this.precio = 600;
            return "Localidad: "+nombre+"\nCapacidad: "+capacidad+"\nPrecio por boleto: "+precio;
        }

        if (pos == 3){
            this.nombre = "Balcón 3";
            this.precio = 300;
            return "Localidad: "+nombre+"\nCapacidad: "+capacidad+"\nPrecio por boleto: "+precio;
        }

        else{
            return "No existe la localidad que desea.";
        }
    }
}