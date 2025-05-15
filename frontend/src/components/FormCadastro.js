import React, { useState } from 'react';

export default function FormCadastro() {
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [tipo, setTipo] = useState('Aluno');
  const [msg, setMsg] = useState('');

  async function handleSubmit(e) {
    e.preventDefault();
    const dados = { nome, email, senha, tipo };

    try {
      const res = await fetch('http://localhost:8080/api/usuarios/cadastrar', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dados),
      });

      if (res.ok) {
        setMsg('Usuário cadastrado com sucesso!');
        setNome('');
        setEmail('');
        setSenha('');
        setTipo('Aluno');
      } else {
        const error = await res.text();
        setMsg('Erro: ' + error);
      }
    } catch (err) {
      setMsg('Erro ao conectar com backend.');
    }
  }

  return (
    <form onSubmit={handleSubmit} style={{ maxWidth: 400, margin: 'auto' }}>
      <h2>Cadastro de Usuário</h2>

      <input
        type="text"
        placeholder="Nome"
        value={nome}
        onChange={e => setNome(e.target.value)}
        required
        style={{ width: '100%', marginBottom: 10 }}
      />

      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={e => setEmail(e.target.value)}
        required
        style={{ width: '100%', marginBottom: 10 }}
      />

      <input
        type="password"
        placeholder="Senha"
        value={senha}
        onChange={e => setSenha(e.target.value)}
        required
        style={{ width: '100%', marginBottom: 10 }}
      />

      <select
        value={tipo}
        onChange={e => setTipo(e.target.value)}
        style={{ width: '100%', marginBottom: 10 }}
      >
        <option value="Aluno">Aluno</option>
        <option value="Professor">Professor</option>
        <option value="Secretaria">Secretaria</option>
      </select>

      <button type="submit" style={{ width: '100%' }}>
        Cadastrar
      </button>

      {msg && <p style={{ marginTop: 10 }}>{msg}</p>}
    </form>
  );
}
