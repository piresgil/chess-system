
package boardgame;

/**
 * Class Piece abstract
 * 
 * Tem metodos abstractos
 *
 */
public abstract class Piece {
	/**
	 * Variaveis - position, board Uma pe�a tem uma position por isso e protetect
	 * 
	 * A pe�a tambem tem uma asocisao com o board
	 */
	protected Position position;
	private Board board;

	/**
	 * Construtor
	 * 
	 * Recebe board
	 */
	public Piece(Board board) {
		this.board = board;
		position = null;// Pe�a recem criada nao tem posisoes por padrao o java ja coloca null...esta so
						// para referencia
	}

	/**
	 * Getters Setters
	 * 
	 * Apenas get board para nao haver altera��es inconsistentes
	 * 
	 * Protected para nao haver altera��es inconsistentes
	 */
	protected Board getBoard() {
		return board;
	}

	/**
	 * Metodo possible Moves
	 * 
	 * Movimentos possiveis Metodo abstracto
	 * 
	 * cria matriz boolean
	 */
	public abstract boolean[][] possibleMoves();

	/**
	 * Metodo possible Move
	 * 
	 * Metodo que utiliza metodo abstracto possibleMoves (faz um hook(gancho) com o
	 * Metodo abstracto)
	 * 
	 * Retorna os movimentos possiveis
	 */

	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	/**
	 * Metodo is any possible move
	 * 
	 * Metodo que mostra movimentos possiveis
	 * 
	 * Percorre a matriz e busca posisoes verdadeiras, para poder mostrar movimentos
	 * possiveis
	 */
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}