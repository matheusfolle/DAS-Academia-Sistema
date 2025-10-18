package view;

import controller.CustomerController;
import model.Customer;
import model.Objective;
import model.Training;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public abstract class CustomerView {
    public static void menu(CustomerController controller, Scanner entry) {
        boolean itsExecuting = true;

        while (itsExecuting) {
            System.out.println("\nMenu de Clientes");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente por ID");
            System.out.println("4 - Remover cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            String opcao = entry.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome do cliente: ");
                    String nome = entry.nextLine();

                    System.out.print("Data de nascimento (dd/MM/yyyy): ");
                    LocalDate nascimento = null;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    try {
                        nascimento = LocalDate.parse(entry.nextLine(), formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato inválido. Use o formato dd/MM/yyyy.");
                    }
                      catch (Exception e){
                        System.out.println("Erro inesperado");
                    }

                    System.out.println("Objetivo: 1 - Hipertrofia  2 - Emagrecimento  3 - Condicionamento  4 - Saúde Geral");
                    int opObj = Integer.parseInt(entry.nextLine());
                    Objective objetivo;
                    switch (opObj) {
                        case 1:
                            objetivo = Objective.HYPERTROPHY;
                            break;
                        case 2:
                            objetivo = Objective.WEIGHT_LOSS;
                            break;
                        case 3:
                            objetivo = Objective.CONDITIONING;
                            break;
                        case 4:
                            objetivo = Objective.GENERAL_HEALTH;
                            break;
                        default:
                            objetivo = Objective.HYPERTROPHY;
                            break;
                    }

                    controller.registerCustomer(nome, nascimento, objetivo);
                    System.out.println("Cliente cadastrado com sucesso.");
                    break;

                case "2":
                    System.out.println("\nLista de Clientes:");
                    List<Customer> clientes = controller.getAllCustomers();
                    for (Customer c : clientes) {
                        System.out.println("ID: " + c.getId() + " | Nome: " + c.getName() + " | Idade: " + c.getAge());

                        for (Object t : c.getTrainingSessions()) {
                            Training tCast = (Training) t;
                            System.out.println(" - " + tCast.getSummary(true));
                        }

                        System.out.println();
                    }
                    break;

                case "3":
                    System.out.print("ID do cliente: ");
                    int idBusca = Integer.parseInt(entry.nextLine());
                    Customer c = controller.findCustomerById(idBusca);
                    System.out.println(c);
                    break;

                case "4":
                    System.out.print("ID do cliente para remover: ");
                    int idRemover = Integer.parseInt(entry.nextLine());
                    controller.removeCustomer(idRemover);
                    System.out.println("Remoção solicitada.");
                    break;

                case "0":
                    itsExecuting = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}