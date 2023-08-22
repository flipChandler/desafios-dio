package br.com.felipe;

/**
 *
 * @see <a href="https://stackoverflow.com/a/24018148">Referência</a>
 *
 * Static factory
 * Lazy initialization
 * Thread safe
 */

public class SingletonLazyHolder {

    private static class InstanceHolder {
        private static final SingletonLazyHolder instance = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
    }

    public static SingletonLazyHolder getInstance() {
        return InstanceHolder.instance;
    }
}
