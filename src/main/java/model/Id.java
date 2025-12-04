package model;

public abstract class Id {
    private final int id;

    public Id(int id) {
        validarTamanho(id);
        validarUnicidade(id);

        this.id = id;
    }

    private void validarTamanho(int id) {
        if (id < 1 || id > 99999) {
            throw new IllegalArgumentException("id_vendedor inválido: valor <= 0 ou valor > 99999 detectado");
        }
    }

    public abstract void validarUnicidade(int id);

    @Override
    public String toString() {
        return "Id{" +
                "id=" + id +
                '}';
    }
}