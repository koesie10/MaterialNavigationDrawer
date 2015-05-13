package it.neokree.materialnavigationdrawer.elements.listeners;

import it.neokree.materialnavigationdrawer.elements.MaterialAccount;

public interface MaterialAccountListener {
    void onAccountOpening(MaterialAccount account);

    void onChangeAccount(MaterialAccount newAccount);
}
