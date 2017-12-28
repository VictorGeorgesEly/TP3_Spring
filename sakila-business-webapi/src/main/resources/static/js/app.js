//'use strict';
//var App = angular.module('myApp', []);

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {actor: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/actor'}).done(response => {
			this.setState({actor: response.entity._embedded.actor});
		});
	}

	render() {
		return (
			<EmployeeList actor={this.state.actor}/>
		)
	}
}

class ActorList extends React.Component{
	render() {
		var actor = this.props.actor.map(actor =>
			<Actor key={actor._links.self.href} actor={actor}/>
		);
		return (
			<table>
				<tbody>
					<tr>
					    <th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						
					</tr>
					{actor}
				</tbody>
			</table>
		)
	}
}

class Actor extends React.Component{
	render() {
		return (
			<tr>
			    <td>{this.props.actor.id}</td>
				<td>{this.props.actor.firstName}</td>
				<td>{this.props.actor.lastName}</td>
			</tr>
		)
	}
}

ReactDOM.render(
		<App />,
		document.getElementById('react')
	)