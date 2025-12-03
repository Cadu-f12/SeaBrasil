package model;

public abstract class Id {
    private final int id;

    public Id(int id) {
        validar(id);

        this.id = id;
    }

    private void validar(int id) {
        if (id < 1 || id > 99999) {
            throw new IllegalArgumentException("id_vendedor inválido: valor <= 0 detectado");
        }
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Id{" +
                "id=" + id +
                '}';
    }
}