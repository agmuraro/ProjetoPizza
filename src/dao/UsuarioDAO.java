package dao;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.*;
import model.Pizza;
import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO {
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;


    public UsuarioDAO(){
        this.conexao = Conexao.getInstancia();
    }

    public void inserirUsuario(Usuario usuario){

        try{
            this.query = "INSERT INTO usuario (email, senha) VALUES (?,?)";
            this.ps = this.conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, usuario.getEmail());
            this.ps.setString(2, usuario.getSenha());
            this.ps.executeUpdate();
            this.ps.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void cadastrarUsuarioCognito(Usuario usuario) {
        try {
            AWSCognitoIdentityProvider conexao = ConexaoCognito.getCognitoClient();

            AdminCreateUserRequest createUserRequest = new AdminCreateUserRequest()
                    .withUserPoolId(ConexaoCognito.USER_POOL_ID)
                    .withUsername(usuario.getEmail())
                    .withUserAttributes(new AttributeType().withName("email").withValue(usuario.getEmail()))
                    .withTemporaryPassword(usuario.getSenha());


            AdminCreateUserResult createUserResult = conexao.adminCreateUser(createUserRequest);

            AdminSetUserPasswordRequest setUserPasswordRequest = new AdminSetUserPasswordRequest()
                    .withUserPoolId(ConexaoCognito.USER_POOL_ID)
                    .withUsername(usuario.getEmail())
                    .withPassword(usuario.getSenha())
                    .withPermanent(true);

            AdminSetUserPasswordResult setUserPasswordResult = conexao.adminSetUserPassword(setUserPasswordRequest);

        } catch (AWSCognitoIdentityProviderException e) {
            e.getErrorMessage();
        }

    }


    public AuthenticationResultType autenticarCognito(String email, String password) {
        try {
            AWSCognitoIdentityProvider conexao = ConexaoCognito.getCognitoClient();

            Map<String, String> authParams = new HashMap<>();
            authParams.put("USERNAME", email);
            authParams.put("PASSWORD", password);

            InitiateAuthRequest authRequest = new InitiateAuthRequest()
                    .withAuthFlow(AuthFlowType.USER_PASSWORD_AUTH)
                    .withClientId(ConexaoCognito.CLIENT_ID)
                    .withAuthParameters(authParams);

            InitiateAuthResult resultado = conexao.initiateAuth(authRequest);

            return resultado.getAuthenticationResult();
        } catch (UserNotFoundException e) {
            e.getErrorMessage();
            return null;
        }
    }
}
