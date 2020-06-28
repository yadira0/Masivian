package co.roulette.api.constant;

public class RouletteConstant {
	
	private RouletteConstant() {
		
	}
	/*
	 * URL´s
	 */
	public static final String ROULETTE_REST_CONTROLLER_NEW_ROULETTE = "/create/roulette";
	public static final String ROULETTE_REST_CONTROLLER_OPEN_ROULETTE = "/open_roulette";
	public static final String ROULETTE_REST_CONTROLLER_CLOSE_ROULETTE = "/close_roulette";
	public static final String ROULETTE_REST_CONTROLLER_REGISTER_BET = "/create_bet";
	public static final String ROULETTE_REST_CONTROLLER_GET_ALL_ROULETTES = "/get_all_roulettes";
	/*
	 * Response codes
	 */
	public static final String ROULETTE_CODE_RESPONSE_SUCCESSFULL = "200, ";
	public static final String ROULETTE_RESPONSE_CODE_FAILED = "400, ";
	public static final String ROULETTE_CODE_RESPONSE_SERVER_INTERNAL_ERROR = "500, ";

	/*
	 * Response Messages
	 */
	public static final String ROULETTE_SUCCESSFUL_MESSAGE = "exitoso";
	public static final String ROULETTE_DENIED_MESSAGE = "denegado";

	/*
	 * Validation message
	 */
	public static final String ROULETTE_VALIDATION_MESSAGE = "Apuesta errónea";

	/*
	 * Headers
	 */
	public static final String ROULETTE_HEADERS_ID_USER = "idUsuario";
	
		
}
