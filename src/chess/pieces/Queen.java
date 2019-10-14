
package chess.pieces;


import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 * Class Queen
 * 
 * Herda de ChessPiece
 *
 */
public class Queen extends ChessPiece {
	/**
	 * Construtor 
	 * 
	 * Busca construtor da Super Class
	 */
	public Queen(Board board, Color color) {
		super(board, color);
	}

	/**
	 * Metodo To String
	 * 
	 *  Busca super class (Override)
	 */
	@Override
	public String toString() {
		return "Q";
	}

	/**
	 * Metodo Possible Moves
	 * 
	 * Busca super class (Override)
	 * 
	 * Cria matriz de boolean(false) com o tamanho do
	 * tabuleiro Cria nova variavel do tipo Position nos valores zero-zero para
	 * fazer testes
	 */
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		/**
		 * Above
		 * 
		 * Seta valores para a posis�o p(row -1) porque a pe�a vai andar para cima(Above)
		 * Enquanto existir posis�o no tabuleiro 
		 * E enquanto não
		 * existir pe�a na posis�o Retorna valor na matriz como True
		 */
		p.setValues(position.getRow() - 1, position.getColumn());//-1) porque a pe�a vai andar para cima(above)
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);//-1) porque a pe�a vai andar para cima(above)
		}
		/**
		 * Testa se existe posis�o no tabuleiro e se existe pe�a do oponente Retorna valor na matriz como True
		 */
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		/**
		 * Left
		 * 
		 * Seta valores para a posis�o p(column -1) porque a pe�a vai andar para esquerda(left)
		 * Enquanto existir posis�o no tabuleiro E enquanto não
		 * existir pe�a na posis�o Retorna valor na matriz como True
		 */
		p.setValues(position.getRow(), position.getColumn() - 1);//-1) porque a pe�a vai andar para esquerda(left)
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);//-1) porque a pe�a vai andar para esquerda(left)
		}
		/**
		 * Testa se existe posis�o no tabuleiro e se existe pe�a do oponente Retorna valor na matriz como True
		 */
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		/**
		 * Rigth
		 * 
		 * Seta valores para a posis�o p(column +1) porque a pe�a vai andar para direita(rigth)
		 * Enquanto existir posis�o no tabuleiro E enquanto não
		 * existir pe�a na posis�o Retorna valor na matriz como True
		 */
		p.setValues(position.getRow(), position.getColumn() + 1);//+1) porque a pe�a vai andar para direita(rigth)
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);//+1) porque a pe�a vai andar para direita(rigth)
		}
		/**
		 * Testa se existe posis�o no tabuleiro e se existe pe�a do oponente Retorna valor na matriz como True
		 */
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		/**
		 * Below
		 * 
		 * Seta valores para a posis�o p(row +1) porque a pe�a vai andar para baixo(Below)
		 * Enquanto existir posis�o no tabuleiro 
		 * E enquanto não
		 * existir pe�a na posis�o Retorna valor na matriz como True
		 */
		p.setValues(position.getRow() + 1, position.getColumn());//+1) porque a pe�a vai andar para baixo(below)
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);//+1) porque a pe�a vai andar para baixo(below)
		}
		/**
		 * Testa se existe posis�o no tabuleiro e se existe pe�a do oponente Retorna valor na matriz como True
		 */
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		/**
		 * NW
		 * 
		 * Nord- este Diagonal Cima esquerda
		 * 
		 * Retorna valor na matriz como True
		 */
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		/**
		 * Testa se existe posis�o no tabuleiro e se existe pe�a do oponente Retorna
		 * valor na matriz como True
		 */
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		/**
		 * NE
		 * 
		 * Norte oeste diaginal Cima direita
		 * 
		 * Retorna valor na matriz como True
		 */
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		/**
		 * Testa se existe posis�o no tabuleiro e se existe pe�a do oponente Retorna
		 * valor na matriz como True
		 */
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		/**
		 * SE
		 * 
		 * Sul este diaginal baixo direita
		 * 
		 * 
		 * Retorna valor na matriz como True
		 */
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
			}

			/**
			 * Testa se existe posis�o no tabuleiro e se existe pe�a do oponente Retorna
			 * valor na matriz como True
			 */
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			/**
			 * SW
			 * 
			 * Sul Este - diagonal baixo-esquerda
			 * 
			 * Retorna valor na matriz como True
			 */
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				p.setValues(p.getRow() + 1, p.getColumn() - 1);
			}
			/**
			 * Testa se existe posis�o no tabuleiro e se existe pe�a do oponente Retorna
			 * valor na matriz como True
			 */
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

		return mat;
	}
}