// src/components/ProductComponent.js

import React, { useState, useEffect } from 'react';
import ProductService from '../services/ProductService';

function ProductComponent() {
    const [products, setProducts] = useState([]);
    const [name, setName] = useState("");
    const [price, setPrice] = useState("");

    useEffect(() => {
        ProductService.getAllProducts().then(response => {
            setProducts(response.data);
        });
    }, []);

    const addProduct = () => {
        ProductService.addProduct(name, price).then(response => {
            setProducts([...products, response.data]);
        });
    };

    const deleteProduct = (id) => {
        ProductService.deleteProduct(id).then(() => {
            setProducts(products.filter(product => product.id !== id));
        });
    };

    return (
        <div>
            <h1>Product List</h1>
            <ul>
                {products.map(product => (
                    <li key={product.id}>
                        {product.name} - ${product.price}
                        <button style={{ marginLeft: '10px' }} onClick={() => deleteProduct(product.id)}>Delete</button>
                    </li>
                ))}
            </ul>
            <h2>Add New Product</h2>
            <input
                type="text"
                placeholder="Name"
                value={name}
                onChange={e => setName(e.target.value)}
            />
            <input
                type="number"
                placeholder="Price"
                value={price}
                onChange={e => setPrice(e.target.value)}
            />
            <button onClick={addProduct}>Add Product</button>
        </div>
    );
}

export default ProductComponent;