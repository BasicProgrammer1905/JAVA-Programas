public class Reservacion{
    private String nombre;
    private String email;
    private int cant;
    private float presu_max;
    private String correlativo;
    private Localidad localidad;
    private int posicion;

    public Reservacion(){
        this.nombre = "";
        this.email = "";
        this.cant = 0;
        this.presu_max = 0;
        this.correlativo = "";
        this.localidad = new Localidad();
        this.posicion = localidad.getPos();
    }

    public Reservacion(String nombre, String email, int cant, float presu_max, String correlativo, Localidad localidad){
        this.nombre = nombre;
        this.email = email;
        this.cant = cant;
        this.presu_max = presu_max;
        this.correlativo = correlativo;
        this.localidad = localidad;
        this.posicion = localidad.getPos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public float getPresu_max() {
        return presu_max;
    }

    public void setPresu_max(float presu_max) {
        this.presu_max = presu_max;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
        this.posicion = localidad.getPos();
    }

    public String toString(){
        if (posicion==1){
            String cadena = "Nombre: "+nombre+"\nEmail: "+email+"\nCantidad de boletos: "+cant+"\nPresupuesto máximo: "+presu_max+"\nLocalidad: Balcón VIP\nCorrelativo: "+correlativo;
            return cadena;
        }

        if (posicion==2){
            String cadena = "Nombre: "+nombre+"\nEmail: "+email+"\nCantidad de boletos: "+cant+"\nPresupuesto máximo: "+presu_max+"\nLocalidad: Balcón Platea\nCorrelativo: "+correlativo;
            return cadena;
        }

        if (posicion==3){
            String cadena = "Nombre: "+nombre+"\nEmail: "+email+"\nCantidad de boletos: "+cant+"\nPresupuesto máximo: "+presu_max+"\nLocalidad: Balcón 3\nCorrelativo: "+correlativo;
            return cadena;
        }

        else{
            return "UM, aqui hay error chicoooo.";
        }
    }
}