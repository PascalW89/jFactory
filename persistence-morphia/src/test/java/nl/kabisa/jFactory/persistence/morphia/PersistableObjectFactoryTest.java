package nl.kabisa.jFactory.persistence.morphia;

import com.google.code.morphia.Datastore;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static nl.kabisa.jFactory.Factory.addFactoryScanPackage;
import static nl.kabisa.jFactory.Factory.create;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PersistableObjectFactoryTest {

    private Datastore datastore = mock(Datastore.class);

    @Before
    public void setup() {
        addFactoryScanPackage("nl.kabisa.jFactory");
        MorphiaBackedPersistableObjectFactory.setDatastore(datastore);
    }

    @Test
    public void createObject() {
        PersistableArticle article = create(PersistableArticle.class, "title", "test");

        verify(datastore).save(article);

        assertEquals("test", article.getTitle());
    }
}
