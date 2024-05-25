package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetArtistGatewayImpl;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static br.com.vvaug.spotifyutils.utils.TestUtils.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)      //anotação importante, importa algumas extensões do JUnit5
public class GetArtistUseCaseImplTest {

    //sempre injetar as Impl e testar as Impl
    @InjectMocks
    private GetArtistUseCaseImpl getArtistUseCase;  //InjectMocks porque você está testando essa classe e ela tem dependências, ou seja, nela, você faz injeção de dependência de outras classes, no caso de GetArtistGateway
    @Mock
    private GetArtistGatewayImpl getArtistGateway; //como ela é uma dependência dessa classe, e você vai precisar Mockar algumas chamadas delas, ela fica com @Mock, e a classe pai, sempre com @InjectMocks

    /*
        anyString() quer dizer "Qualquer String"
        Ex:
        when(getArtistGateway.getArtist(anyString(), anyString())).thenReturn(expected);
        Quando o método getArtist for executado com qualquer String no primeiro parâmetro e qualquer String no segundo parâmetro, devolva o objeto armazenado em expected.
     */
    @Test
    public void execute (){
        ArtistResponse expected = ArtistResponse.builder().build(); //objeto esperado quando o gateway for executado
        when(getArtistGateway.getArtist(anyString(), anyString())).thenReturn(expected); //quando gateway for executado, retorne o objeto criado na linha acima
        ArtistResponse response = getArtistUseCase.execute(ID, AUTHORIZATION); // aqui o UseCase é executado. O fluxo é o UseCase chamar o Gateway. Como Mockamos o Gateway acima para devolver um objeto vazio, o "expected" é ele que será devolvido, pois o Gateway está mockado o when significa (Quando o gateway.metodoX for executado Devolva um Objeto Mockado, no caso o expected)
        verify(getArtistGateway, atLeastOnce()).getArtist(anyString(), anyString()); //esse verify usamos para verificar se o nosso Mock (Gateway) foi realmente sensibilizado | Sintaxe: verify (mock, verificacao).metodo(parametro)  O que usamos aqui foi:  Verifique se o mock getArtistGateway executou PELO MENOS UMA VEZ (AT LEAST ONCE) o método getArtist com qualquer String no primeiro e no segundo parâmetro.
        assertEquals(expected, response); //aqui utilizamos o método assertEquals do JUnit 5 para termos mais uma certeza que o teste foi o sucesso verificando se o objeto mockado "expected" foi o que foi devolvido quando chamamos o UseCase (expected & response) = true
    }
}
