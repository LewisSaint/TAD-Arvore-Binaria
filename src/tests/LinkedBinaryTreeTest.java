package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import position.ElementIterator;
import org.junit.jupiter.api.Test;
import position.Position;
import src.BTNode;
import src.LinkedBinaryTree;


class LinkedBinaryTreeTest {

    @Test
    void Test() {

        LinkedBinaryTree<String> paisArvore = new LinkedBinaryTree<String>();

        paisArvore.addRoot("China");

        assertEquals("China", paisArvore.root().element(), "China");

        paisArvore.insertLeft(paisArvore.root(), "Japão");

        assertEquals("Japão", paisArvore.left(paisArvore.root()).element());

        paisArvore.insertRight(paisArvore.root(), "Coreia");

        assertEquals("Coreia", paisArvore.right(paisArvore.root()).element());

        assertEquals("China",paisArvore.parent(paisArvore.left(paisArvore.root())).element());

        assertEquals(true, paisArvore.hasLeft(paisArvore.root()));

        assertEquals("China", paisArvore.parent(paisArvore.left(paisArvore.root())).element());

        assertEquals(true, paisArvore.isInternal(paisArvore.root()));


        LinkedBinaryTree<String> europa = new LinkedBinaryTree<String>();

        europa.addRoot("Alemanha");

        europa.insertRight(europa.root(), "Dinamarca");

        europa.insertLeft(europa.root(), "Belgica");

        BTNode mundo = new BTNode("ONU", null, null, null);

        europa.attach(mundo, europa, paisArvore);

        assertEquals("Alemanha", mundo.getLeft().element());

        assertEquals("Belgica", mundo.getLeft().getLeft().element());

    }


    @Test
    void buildExpressionTest() {
        LinkedBinaryTree teste = new LinkedBinaryTree();


        String expressao = "((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))";


        assertEquals('-',teste.buildExpression(expressao).root().element());


    }


    @Test
    void evaluateExpressionTest() {
        LinkedBinaryTree teste = new LinkedBinaryTree();

        String expressao = "((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))";

        assertEquals(-13, teste.evaluateExpression(teste.buildExpression(expressao), (BTNode)teste.buildExpression(expressao).root()));

    }

}