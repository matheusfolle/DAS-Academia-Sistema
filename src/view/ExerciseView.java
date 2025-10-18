package view;

import controller.ExerciseController;
import java.util.List;
import java.util.Scanner;
import model.Exercise;

public abstract class ExerciseView {
    public static void menu(ExerciseController controller, Scanner entry) {
        boolean itsExecuting = true;

        while (itsExecuting) {
            System.out.println("\nMenu de Exercícios");
            System.out.println("1 - Cadastrar exercício");
            System.out.println("2 - Listar exercícios");
            System.out.println("3 - Remover exercício");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            String opcao = entry.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome do exercício: ");
                    String nome = entry.nextLine();
                    System.out.print("Repetições: ");
                    String repeticoes = entry.nextLine();
                    System.out.print("Séries: ");
                    String series = entry.nextLine();
                    controller.registerExercise(nome, repeticoes, series);
                    System.out.println("Exercício cadastrado com sucesso!");
                    break;

                case "2":
                    System.out.println("\nLista de Exercícios:");
                    List<Exercise> exercicios = controller.getAllExercises();
                    for (Exercise e : exercicios) {
                        System.out.println("ID " + e.getId() + ": " + e);
                    }
                    break;

                case "3":
                    System.out.print("ID do exercício a remover: ");
                    int id = Integer.parseInt(entry.nextLine());
                    controller.removeExercise(id);
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