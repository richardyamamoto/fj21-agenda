package br.com.caelum.dao;

import br.com.caelum.factory.ConnectionFactory;
import br.com.caelum.modelo.Contato;

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
        String sqlQuery = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getEndereco());
            statement.setString(4, new Date(contato.getDataNascimento().getTimeInMillis()).toString());

            statement.execute();
            statement.close();
            connection.close();

        }catch(SQLException err) {
            throw new RuntimeException(err);
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
