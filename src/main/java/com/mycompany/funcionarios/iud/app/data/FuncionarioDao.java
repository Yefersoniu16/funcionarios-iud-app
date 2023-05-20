package com.mycompany.funcionarios.iud.app.data;

import com.mycompany.funcionarios.iud.app.domain.Funcionario;
import com.mycompany.funcionarios.iud.app.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    private static final String GET_FUNCIONARIOS = "select * from funcionario ";

    private static final String CREATE_FUNCIONARIO = "insert into funcionario (tipo_doccumento, numero_documento, nombre, apellido, estado_civil, sexo, direccion, telefono, fecha_nacimiento) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    private static final String GET_FINCIONARIO_BY_ID = "select * from funcionario where id = ?";

    private static final String UPDATE_FINCIONARIO = "update funcionario set tipo_doccumento = ?, numero_documento = ?, nombre = ?, apellido = ?, estado_civil = ?, sexo = ?, direccion = ?, telefono = ?, fecha_nacimiento = ? where id = ?";

    private static final String DELETE_FUNCIONARO = "delete  from funcionario where id = ? ";

    public List<Funcionario> obtenerFun() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnectios();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipo_doccumento(resultSet.getString("tipo_doccumento"));
                funcionario.setNumero_documento(resultSet.getString("numero_documento"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setEstado_civil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
                funcionarios.add(funcionario);

            }
            return funcionarios;

        } finally {

            if (connection != null) {
                connection.close();

            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

        }

    }

    public void crear(Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnectios();
            preparedStatement = connection.prepareStatement(CREATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipo_doccumento());
            preparedStatement.setString(2, funcionario.getNumero_documento());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellido());
            preparedStatement.setString(5, funcionario.getEstado_civil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFecha_nacimiento());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();

            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }

    }

    public Funcionario obtenerFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {

            connection = ConnectionUtil.getConnectios();
            preparedStatement = connection.prepareStatement(GET_FINCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipo_doccumento(resultSet.getString("tipo_doccumento"));
                funcionario.setNumero_documento(resultSet.getString("numero_documento"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setEstado_civil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
            }

            return funcionario;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

        }

    }

    public void actualizarFunc(int id, Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnectios();
            preparedStatement = connection.prepareStatement(UPDATE_FINCIONARIO);
            preparedStatement.setString(1, funcionario.getTipo_doccumento());
            preparedStatement.setString(2, funcionario.getNumero_documento());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellido());
            preparedStatement.setString(5, funcionario.getEstado_civil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFecha_nacimiento());
            preparedStatement.setInt(10, funcionario.getId());
            preparedStatement.executeUpdate();

        } finally {

            if (connection != null) {
                connection.close();

            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void eliminarFuncionario(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnectios();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARO);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
     

        } finally {

            if (connection != null) {
                connection.close();

            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }

    }

}
