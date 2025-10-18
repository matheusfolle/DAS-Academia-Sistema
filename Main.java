import controller.*;
import dal.*;
import view.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList customerList = new ArrayList();
        ArrayList exercisesList = new ArrayList();
        ArrayList trainingList = new ArrayList();

        try {
            customerList = (ArrayList) CustomerDAO.load();
        } catch (Exception e) {
            System.out.println("Nenhum cliente carregado.");
        }

        try {
            exercisesList = (ArrayList) ExerciseDAO.load();
        } catch (Exception e) {
            System.out.println("Nenhum exercício carregado.");
        }

        try {
            trainingList = (ArrayList) TrainingDAO.load();
        } catch (Exception e) {
            System.out.println("Nenhum treino carregado.");
        }

        CustomerController customerController = new CustomerController(customerList);
        ExerciseController exerciseController = new ExerciseController(exercisesList);
        TrainingController trainingController = new TrainingController();

        Scanner entry = new Scanner(System.in);
        boolean itsExecuting = true;

        while (itsExecuting) {
            System.out.println("\nBem-vindo ao sistema gerenciador de Academia!");
            System.out.println("\nMenu Principal");
            System.out.println("1 - Gerenciar clientes");
            System.out.println("2 - Gerenciar exercícios");
            System.out.println("3 - Gerenciar treinos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            String option = entry.hasNextLine() ? entry.nextLine() : "0";

            switch (option) {
                case "1":
                    CustomerView.menu(customerController, entry);
                    break;
                case "2":
                    ExerciseView.menu(exerciseController, entry);
                    break;
                case "3":
                    TrainingView.menu(customerController, exerciseController, trainingController, trainingList, entry);
                    break;
                case "0":
                    itsExecuting = false;
                    System.out.println("Encerrando o sistema.");
                    try {
                        CustomerDAO.save(customerController.getAllCustomers());
                        ExerciseDAO.save(exerciseController.getAllExercises());
                        TrainingDAO.save(trainingList);
                        System.out.println("Dados salvos com sucesso!");
                    } catch (IOException e) { 
                        System.err.println("Erro I/O ao salvar dados: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro inesperado " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        entry.close();
    }
}