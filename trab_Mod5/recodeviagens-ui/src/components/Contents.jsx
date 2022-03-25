import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container, ButtonGroup, Table } from 'reactstrap';
import AppNavBar from './AppNavBar';

class Contents extends Component {

    constructor(props) {
        super(props);
        this.state = {
            customers: []
        };
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/customer')
            .then(response => response.json())
            .then(data => this.setState({ customers: data }));
    }

    async remove(id) {
        await fetch(`/customer/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCustomers = [...this.state.customers].filter(i => i.id !== id);
            this.setState({ customers: updatedCustomers });
        });
    }

    render() {
        const { customers, isLoading } = this.state;

        if (isLoading) {
            return <p>Aguarde</p>;
        }

        const customerList = customers.map(customer => {
            return <tr key={customer.id}>
                <td style={{ whiteSpace: 'nowrap' }}>{customer.name}</td>
                <td>{customer.email}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/customer/" + customer.id}>Alterar</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(customer.id)}>Apagar</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavBar />
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/customer/new">Incluir Cliente</Button>
                    </div>
                    <h3>Clientes</h3>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                                <th width="30%">Nome</th>
                                <th width="30%">E-mail</th>
                                <th width="40%">Opções</th>
                            </tr>
                        </thead>
                        <tbody>
                            {customerList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default Contents;