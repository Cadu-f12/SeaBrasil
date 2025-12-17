package dao;

import java.util.ArrayList;

public interface Pesquisas<T> {

    T lerId(T entidade);
    ArrayList<T> listar();
}