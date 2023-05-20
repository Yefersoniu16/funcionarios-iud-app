package com.mycompany.funcionarios.iud.app.controller;

import com.mycompany.funcionarios.iud.app.data.FuncionarioDao;
import com.mycompany.funcionarios.iud.app.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    
    private FuncionarioDao funcionarioDao;
    
    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
        
    }
    
    public List<Funcionario> obtenerFun() throws SQLException {     
        return funcionarioDao.obtenerFun();
    }

    public void crear(Funcionario funcionario) throws SQLException {
        funcionarioDao.crear(funcionario);
        
    }
    
    public Funcionario obtentenerFuncionario(int id) throws SQLException {     
        return funcionarioDao.obtenerFuncionario(id);
    }
    
    public void actualizarFun(int id, Funcionario funcionario) throws SQLException {
         funcionarioDao.actualizarFunc(id, funcionario);
    }
    
    public void eliminarFun(int id) throws SQLException {
        funcionarioDao.eliminarFuncionario(id);
    }
}
