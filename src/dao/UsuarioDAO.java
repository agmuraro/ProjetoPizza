package dao;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserRequest;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserResult;
import com.amazonaws.services.cognitoidp.model.AttributeType;
import com.amazonaws.services.cognitoidp.model.AuthFlowType;
import com.amazonaws.services.cognitoidp.model.AuthenticationResultType;
import com.amazonaws.services.cognitoidp.model.InitiateAuthRequest;
import com.amazonaws.services.cognitoidp.model.InitiateAuthResult;
import model.Usuario;

import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO {

    public void cadastrarUsuarioCognito(Usuario usuario) {
        try {
            AWSCognitoIdentityProvider conexao = ConexaoCognito.getCognitoClient();

            AdminCreateUserRequest createUserRequest = new AdminCreateUserRequest()
                    .withUserPoolId(ConexaoCognito.USER_POOL_ID)
                    .withUsername(usuario.getEmail())
                    .withUserAttributes(new AttributeType().withName("email").withValue(usuario.getEmail()))
                    .withTemporaryPassword(usuario.getSenha());

            AdminCreateUserResult createUserResult = conexao.adminCreateUser(createUserRequest);

        } catch (Exception e) {
            e.getMessage();
        }

    }}
