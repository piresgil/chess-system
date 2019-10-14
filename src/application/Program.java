package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

/**
 * Class Program
 *
 */
public class Program {
	public static void main(String[] args) {

		/**
		 * Inicia Scanner
		 * 
		 * Inicia ChessMatch
		 * 
		 * Inicia Lista de peças capturadas 
		 */

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();

		/**
		 * Estrutura Enquanto -> não houver chekMate
		 */
		while (!chessMatch.getcheckMate()) {
			try {// para tratamento das excepçoes
				UI.clearScreen();// limpa tela
				UI.printMatch(chessMatch, captured);// imprime tabuleiro de jogo

				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);// verifica a source position

				boolean[][] posibleMoves = chessMatch.possibleMoves(source);// verifica movimentos possiveis
				UI.clearScreen();// limpa tela
				UI.printBoard(chessMatch.getPieces(), posibleMoves);// imprime tabuleiro de jogo

				System.out.println();

				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);// verifica target position

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);// verifica se existe peça
																						// capturada

				if (capturedPiece != null) {// testa se existe peçasa capturada
					captured.add(capturedPiece);// se existir addiciona ha lista
				}
				
				if(chessMatch.getPromoted()!=null) {
					System.out.print("Enter piece for promotion ([B]/[N]/[R]/[Q]) :");
					String type=sc.nextLine();
					chessMatch.replacePromotedPiece(type);
							
				}
			}

			catch (ChessException e) {// klk excepãoo do tipo ChessException
				System.out.println(e.getMessage());// mostra menssagem
				sc.nextLine();// espera clicar enter
			} catch (InputMismatchException e) {// klk excepãoo do tipo InputMismatchException
				System.out.println(e.getMessage());// mostra msg
				sc.nextLine();// espera clicar enter
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}