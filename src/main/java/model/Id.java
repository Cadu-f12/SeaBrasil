package model;

public class Id {
    private int id;

    public Id(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        validarTamanho(id);

        this.id = id;
    }

    private void validarTamanho(int id) {
        if (id < 1 || id > 99999) {
            System.err.println("Exceção disparado de: Id.validarTamanho");
            throw new IllegalArgumentException("id_vendedor inválido: valor <= 0 ou valor > 99999 detectado");
        }
    }

    @Override
    public String toString() {
        return "Id{" +
                "id=" + id +
                '}';
    }
}