
package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

/**
 * Class Pawn
 * 
 * Herda de ChessPiece
 *
 */
public class Pawn extends ChessPiece {

	/**
	 * Dependencia
	 */
	private ChessMatch chessMatch;

	/**
	 * 
	 * Construtor
	 * 
	 * Busca construtor da Super Class
	 */
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	/**
	 * Metodo To String
	 * 
	 * Busca super class (Override)
	 */
	@Override
	public String toString() {
		return "P";
	}

	/**
	 * Metodo Possible Moves
	 * 
	 * Busca super class (Override)
	 * 
	 * Cria matriz de boolean(false) com o tamanho do tabuleiro Cria nova variavel
	 * do tipo Position nos valores zero-zero para fazer testes
	 */
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		/**
		 * Above 1x
		 * 
		 * Testa cor Seta valores para a posis�o p(row -1) porque a pe�a vai andar para
		 * cima(Above) SE existir posis�o no tabuleiro E não existir pe�a na posis�o
		 * 
		 * Retorna valor na matriz como True
		 */
		if (getColor() == Color.White) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			/**
			 * Above x2
			 * 
			 * Seta valores para a posis�o p(row -2) porque a pe�a vai andar 2 casas para
			 * cima(Above)
			 * 
			 * cria nova pocisão para receber Position
			 * 
			 * testa SE existir posis�o no tabuleiro E não existir pe�a na posis�o tanto na
			 * pe�a p como na p2
			 * 
			 * Retorna valor na matriz como True
			 */
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			/**
			 * Diagonal left
			 * 
			 * Seta valores para a posis�o p(row -1)(column -1) porque a pe�a vai andar na
			 * Diagonal esquerda SE existir posis�o no tabuleiro E existir pe�a oponente na
			 * posis�o
			 * 
			 * Retorna valor na matriz como True
			 */
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			/**
			 * Diagonal Rigth
			 * 
			 * Seta valores para a posis�o p(row -1)(column +1) porque a pe�a vai andar na
			 * Diagonal direita SE existir posis�o no tabuleiro E existir pe�a oponente na
			 * posis�o
			 * 
			 * Retorna valor na matriz como True
			 */
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// especial move en passant
			// há esquerda
			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getenPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				// especial move en passant
				// há direita
				Position rigth = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(rigth) && isThereOpponentPiece(rigth)
						&& getBoard().piece(rigth) == chessMatch.getenPassantVulnerable()) {
					mat[rigth.getRow() - 1][rigth.getColumn()] = true;
				}
			}

		} else {
			/**
			 * Above 1x
			 * 
			 * Testa cor Seta valores para a posis�o p(row +1) (porque a pe�a e preta e anda
			 * para baixo k é +1) vai andar para cima(Above) SE existir posis�o no tabuleiro
			 * E não existir pe�a na posis�o
			 * 
			 * Retorna valor na matriz como True
			 */
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			/**
			 * Above x2
			 * 
			 * Seta valores para a posis�o p(row +2) porque a pe�a vai andar 2 casas para
			 * cima(Above)(porque a pe�a e preta e anda para baixo k é +1)
			 * 
			 * cria nova pocisão para receber Position
			 * 
			 * testa SE existir posis�o no tabuleiro E não existir pe�a na posis�o tanto na
			 * pe�a p como na p2
			 * 
			 * Retorna valor na matriz como True
			 */
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			/**
			 * Diagonal left
			 * 
			 * Seta valores para a posis�o p(row +1)(porque a pe�a e preta e anda para baixo
			 * k é +1)(column -1) porque a pe�a vai andar na Diagonal esquerda SE existir
			 * posis�o no tabuleiro E existir pe�a oponente na posis�o
			 * 
			 * Retorna valor na matriz como True
			 */
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			/**
			 * Diagonal Rigth
			 * 
			 * Seta valores para a posis�o p(row +1)(porque a pe�a e preta e anda para baixo
			 * k é +1)(column +1) porque a pe�a vai andar na Diagonal direita SE existir
			 * posis�o no tabuleiro E existir pe�a oponente na posis�o
			 * 
			 * Retorna valor na matriz como True
			 */
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// especial move en passant
			// há esquerda
			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getenPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				// especial move en passant
				// há direita
				Position rigth = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(rigth) && isThereOpponentPiece(rigth)
						&& getBoard().piece(rigth) == chessMatch.getenPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
			}
		}
		return mat;
	}
}
