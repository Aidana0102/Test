package org.example.dao;

import org.example.models.GKPO;
import org.example.models.Payment;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PaymentDao {



        private static final String url="jdbc:postgresql://localhost:5432/EducationalWebApp";//change the DB

        private static  final String username="postgres";
        private static final String password="1234";


        private static Connection connection;
        static {

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection(url, username, password);
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }

        public List<Payment> index()  {
            List<Payment> payments = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                String SQL = "Select * from person";
                ResultSet resultSet = statement.executeQuery(SQL);

                while (resultSet.next()) {
                  //  payment.setPayersName(resultSet.getString("payersName"));

                    Payment payment = new Payment();
                    payment.setPayersAccount(resultSet.getLong("payersAccount"));
                    payment.setPayersBIK(resultSet.getLong("payersBIK"));
                    payment.setDateOfExecution(resultSet.getDate("dateOfExecution"));
                    payment.setPaymentDate(resultSet.getDate("paymentDate"));
                    payment.setBeneficiarysName(resultSet.getString("beneficiarysName"));
                    payment.setBeneficiarysAccount(resultSet.getLong("beneficiarysAccount"));
                    payment.setINN(resultSet.getLong("INN"));
                    payment.setBeneficiarysBIK(resultSet.getLong("beneficiarysBIK"));
                    payment.setAmount(resultSet.getLong("amount"));
                    payment.setGKPO(GKPO.valueOf(resultSet.getString("GKPO")));
                    payment.setPurposeOfPayment(resultSet.getString("purposeOfPayment"));



                    payments.add(payment);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return payments;
        }





    public static void save(Payment payment) {
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("INSERT INTO Person VALUES(1,?, ?, ?,?, ?,?, ?,?, ?,?, ?,?)");

                preparedStatement.setString(1, payment.getPayersName());

                preparedStatement.setLong(2, payment.getPayersAccount());
                preparedStatement.setLong(3, payment.getPayersBIK());

                preparedStatement.setDate(4, (Date) payment.getDateOfExecution());

                preparedStatement.setString(5, payment.getBeneficiarysName());

                preparedStatement.setLong(6, payment.getBeneficiarysAccount());
                preparedStatement.setLong(7, payment.getINN());

                preparedStatement.setLong(8, payment.getBeneficiarysBIK());

                preparedStatement.setLong(9, payment.getAmount());

           //     preparedStatement.setString(10, payment.getGKPO().getGkpo());

                preparedStatement.setString(11, payment.getPurposeOfPayment());

                preparedStatement.setDate(12, (Date) payment.getPaymentDate());


                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }






}
