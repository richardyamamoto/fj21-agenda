package br.com.caelum.dao;

import br.com.caelum.factory.ConnectionFactory;
import br.com.caelum.modelo.Contato;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {
    private Connection connection;

    public ContatoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Contato contato) {
        System.out.println("Start ContatoDao -> adiciona()");
        String sqlQuery = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getEndereco());
            statement.setString(4, new Date(contato.getDataNascimento().getTimeInMillis()).toString());

            System.out.println(statement);
            statement.execute();
            statement.close();
            connection.close();
            System.out.println("End ContatoDao -> adiciona()");
        }catch(SQLException err) {
            throw new RuntimeException(err);
        }
    }

    public void altera(Contato contato) {
        String sqlQuery = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
        try{
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, contato.getNome());
            System.out.println(contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getEmail());
            statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            statement.setLong(5, contato.getId());
            System.out.println(contato.getId());
            System.out.println(statement);
            statement.execute();
            statement.close();
            connection.close();
        }catch(SQLException e) {
            System.out.println("Ocorreu uma exeção em ContatoDao -> altera()");
            throw new RuntimeException(e);
        }
    }
    public List<Contato> getLista() {
        String sqlQuery = "select * from contatos";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            List<Contato> contatos = new ArrayList<Contato>();
            while (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getLong("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setEmail(resultSet.getString("email"));
                contato.setEndereco(resultSet.getString("endereco"));
                Calendar data = Calendar.getInstance();
                data.setTime(resultSet.getDate("dataNascimento"));
                contato.setDataNascimento(data);
                contatos.add(contato);
            }
            resultSet.close();
            connection.close();
            return contatos;
        }catch(SQLException err) {
            throw new RuntimeException(err);
        }
    }

    public void exclui(Contato contato) {
        String sqlQuery = "delete from contatos where id=?";
        try{
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, contato.getId());
            statement.execute();
            statement.close();
            connection.close();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
